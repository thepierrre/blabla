package com.piotr.postgresdatabase.repositories;

import com.piotr.postgresdatabase.TestDataUtil;
import com.piotr.postgresdatabase.domain.entities.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
// Clean any changes made to the context (including DB) bc e.g. we have two tests that create authorA
// and we don't want authorA to already exist in DB when we run the second test
public class AuthorRepositoryIntegrationTests {

    private AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntity); // same as "create" in JDBC
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId()); // same as "findOne" in JDBC
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntityA);
        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();
        underTest.save(authorEntityB);
        AuthorEntity authorEntityC = TestDataUtil.createTestAuthorC();
        underTest.save(authorEntityC);

        Iterable<AuthorEntity> result = underTest.findAll(); // same as "find" in JDBC; Iterable instead of List
        assertThat(result)
                .hasSize(3)
                .containsExactly(authorEntityA, authorEntityB, authorEntityC);

    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntityA);
        authorEntityA.setName("UPDATED");
        underTest.save(authorEntityA);
        Optional<AuthorEntity> result = underTest.findById(authorEntityA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntityA);
        // 'save' is used both for creating and updating in Spring Data JPA
    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntityA);
        underTest.deleteById(authorEntityA.getId());
        Optional<AuthorEntity> result = underTest.findById(authorEntityA.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testThatGetAuthorsWithAgeLessThan() {
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorAEntity);
        AuthorEntity testAuthorBEntity = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorBEntity);
        AuthorEntity testAuthorCEntity = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorCEntity);

        Iterable<AuthorEntity> result = underTest.ageLessThan(50);
        assertThat(result).containsExactly(testAuthorBEntity, testAuthorCEntity);
    }

    @Test
    public void testThatGetAuthorsWithAgeGreaterThan() {
        AuthorEntity testAuthorAEntity = TestDataUtil.createTestAuthorA();
        underTest.save(testAuthorAEntity);
        AuthorEntity testAuthorBEntity = TestDataUtil.createTestAuthorB();
        underTest.save(testAuthorBEntity);
        AuthorEntity testAuthorCEntity = TestDataUtil.createTestAuthorC();
        underTest.save(testAuthorCEntity);

        Iterable<AuthorEntity> result = underTest.findAuthorsWithAgeGreaterThan(50);
        assertThat(result).containsExactly(testAuthorAEntity);
    }
}

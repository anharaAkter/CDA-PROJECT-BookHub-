package com.bookhub.bookhubapi.Services;
import com.bookhub.bookhubapi.Repositories.AuthorRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;


class AuthorServiceTest {

    @Mock
    private AuthorRepo authorRepo;
    private AutoCloseable autoCloseable;
    private AuthorService authorServiceTest;

    @BeforeEach
    void setUp() {
        autoCloseable=MockitoAnnotations.openMocks(this);
        authorServiceTest = new AuthorService(authorRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void itShouldGCheckIfGetAllAuthor() {
        //given
        //when
        authorServiceTest.getAllAuthor();

        //then
        verify(authorRepo).findAll();
    }
}
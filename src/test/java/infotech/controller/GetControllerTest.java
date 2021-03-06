package infotech.controller;

import infotech.domain.DataBaseObject;
import infotech.repo.ObjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@WebMvcTest(GetController.class)
public class GetControllerTest {

    @MockBean
    private ObjectRepository repository;

    @Before
    public void setUp() {
        DataBaseObject testObject = new DataBaseObject.Builder()
                .withKey("TEST")
                .withAttributes("test")
                .withTTL("00:10")
                .withCreationTime(LocalDateTime.now())
                .withDeleteTime()
                .build();

        Mockito.when(repository.findByKey(testObject.getKey()))
                .thenReturn(testObject);
    }

    @Test
    public void whenValidKey_thenObjectShouldBeFound() {
        String key = "TEST";
        DataBaseObject found = repository.findByKey(key);

        assertThat(found.getKey()).isEqualTo(key);
    }


}
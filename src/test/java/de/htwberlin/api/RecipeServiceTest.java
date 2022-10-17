package de.htwberlin.api;


import de.htwberlin.persistence.RecipeRepository;
import de.htwberlin.services.RecipeService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest implements WithAssertions {

@Mock
    private RecipeRepository repository;

@InjectMocks
    private RecipeService test;



    @Test
    @DisplayName("should return true if delete was successful")
    void deleteSuccess(){
    Long givenId = 1L;
    doReturn(true).when(repository).existsById(givenId);


    //when
    boolean result = test.deleteById(givenId);

    //then
    verify(repository).deleteById(givenId);
    assertThat(result).isTrue();
}
    @Test
    @DisplayName("should return true if delete was successful")
    void deleteFailed(){
        Long givenId = 1L;
        doReturn(false).when(repository).existsById(givenId);


        //when
        boolean result = test.deleteById(givenId);

        //then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }


}

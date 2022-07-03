package de.htwberlin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    @Query(value = "SELECT r FROM recipes r WHERE LOWER(r.name) LIKE CONCAT('%', :name, '%')")
    List<RecipeEntity> findAllByName(@Param("name") String name);

    List<RecipeEntity> findAllByLiked(boolean liked);
}

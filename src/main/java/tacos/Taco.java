package tacos;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Taco {
        @Id
        private Long id;

        @NotNull
        @Size(min=5, message="Name must be at least 5 characters long")
        private String name;

        @NotNull
        @Size(min=1, message="You must choose at least 1 ingredient")
        private List<IngredientRef> ingredients = new ArrayList<>();

        private Date createdAt = new Date();

        public void addIngredient(Ingredient ingredient) {
                this.ingredients.add(new IngredientRef(ingredient.getId()));
        }
}

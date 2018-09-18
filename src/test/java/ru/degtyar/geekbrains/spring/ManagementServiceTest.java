package ru.degtyar.geekbrains.spring;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.degtyar.geekbrains.spring.configuration.ApplicationConfiguration;
import ru.degtyar.geekbrains.spring.model.Category;
import ru.degtyar.geekbrains.spring.service.CategoryService;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ManagementServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void test(){
        Category category = new Category();
        category.setId("1");
        category.setName("Category");
        categoryService.save(category);
    }
}

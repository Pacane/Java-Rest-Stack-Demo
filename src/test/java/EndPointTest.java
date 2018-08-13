import com.flextrade.jfixture.JFixture;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pacane.PersonEndPoint;
import org.pacane.Person;
import org.pacane.PersonService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(JukitoRunner.class)
public class EndPointTest {
    @Inject
    PersonService personService;
    @Inject
    PersonEndPoint personEndPoint;

    private JFixture fixture = new JFixture();

    @Test
    public void returns404WhenPersonNotFound() {
        given(personService.getLastPersonAdded()).willReturn(null);

        Response response = personEndPoint.getLastPerson();

        assertThat(response.getStatus()).isEqualTo(404);
    }

    @Test
    public void returns200WhenpersonIsFound() {
        Person somePerson = fixture.create(Person.class);
        given(personService.getLastPersonAdded()).willReturn(somePerson);

        Response response = personEndPoint.getLastPerson();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    public static class Module extends JukitoModule {
        @Override
        protected void configureTest() {
            forceMock(PersonService.class);
        }
    }
}

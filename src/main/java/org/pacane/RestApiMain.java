package org.pacane;


import io.undertow.Undertow;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

public class RestApiMain {
    private static final String APPLICATION_PATH = "/api";

    public static void main(String[] args) {
        PersonComponent app = DaggerPersonComponent.builder().build();

        bootstrapRepository(app);

        UndertowJaxrsServer server = new UndertowJaxrsServer();

        ResteasyDeployment deployment = new ResteasyDeployment();
        DemoApplication demoApplication = new DemoApplication(app);
        deployment.setApplication(demoApplication);
        deployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");

        DeploymentInfo deploymentInfo = server.undertowDeployment(deployment, "/");
        deploymentInfo.setClassLoader(RestApiMain.class.getClassLoader());
        deploymentInfo.setDeploymentName("Undertow + Resteasy example");
        deploymentInfo.setContextPath(APPLICATION_PATH);
        deploymentInfo.addListener(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));

        server.deploy(deploymentInfo);
        Undertow.Builder builder = Undertow.builder()
                .addHttpListener(8080, "localhost");

        server.start(builder);
    }

    private static void bootstrapRepository(PersonComponent app) {
        PersonService service = app.getPersonService();
        Person p1 = new Person();
        p1.name = "Kenneth";
        p1.age = 25;

        service.add(p1);
    }
}

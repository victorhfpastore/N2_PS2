package br.mack.victor;

import br.mack.victor.db.AlunoDao;
import br.mack.victor.resources.AlunoResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class AlunoServiceApplication extends Application<AlunoServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new AlunoServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "AlunoService";
    }

    @Override
    public void initialize(final Bootstrap<AlunoServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<AlunoServiceConfiguration>() {
            @Override
            public void run(AlunoServiceConfiguration AlunoServiceConfiguration, Environment environment) throws Exception {
            }

            @Override
            public DataSourceFactory getDataSourceFactory(AlunoServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }

            @Override
            public String name() {
                return "db";
            }
        });
    }

    @Override
    public void run(final AlunoServiceConfiguration configuration,
                    final Environment environment) {

        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        AlunoDao AlunoDao = jdbi.onDemand(AlunoDao.class);

        //Resources
        AlunoResource AlunoResource = new AlunoResource(AlunoDao);
        environment.jersey().register(AlunoResource);

    }



}

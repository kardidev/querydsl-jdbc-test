package com.kardi.test.maven.querydsl.generator;

import com.querydsl.sql.codegen.MetaDataExporter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Mojo(name = "h2server", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class QGenerator extends AbstractMojo {

    private static final String H2_CONNECTION_STRING = "jdbc:h2:mem:test;MODE=MySQL";

    @Parameter(property = "h2server.targetPackage", required = true)
    private String targetPackage;

    @Parameter(property = "h2server.targetFolder", defaultValue = "target/generated-sources/java")
    private String targetFolder;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            createDatabase();
        } catch (Exception e) {
            throw new MojoExecutionException("OMG!", e);
        }
    }

    private void createDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(H2_CONNECTION_STRING, "sa", "");
        try {

            // TODO : change to execute script outside
            Statement stat = connection.createStatement();
            stat.execute("CREATE TABLE ACTIVITY (ID INTEGER, STARTTIME datetime, ENDTIME datetime,  ACTIVITY_NAME VARCHAR(200),  PRIMARY KEY (ID))");

            MetaDataExporter exporter = new MetaDataExporter();
            exporter.setPackageName(targetPackage);
            exporter.setTargetFolder(new File(targetFolder));
            exporter.export(connection.getMetaData());

        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                // do nothing
            }
        }

    }
}

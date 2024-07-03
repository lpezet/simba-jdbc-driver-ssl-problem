import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.sql.Connection;

import javax.net.ssl.HttpsURLConnection;

public class SSLTest {

  public void check1() {
    System.out.println("######################### CHECK1: START ##########################");
    try {
      URL url = new URL(
          "https://pipelinesghubeus9.actions.githubusercontent.com/abcdef/00000000-0000-0000-0000-000000000000/_apis/distributedtask/hubs/Actions/plans/abcde-1234-abcde-12345/jobs/12345-abcde-12345-abcde/idtoken?api-version=2.0&audience=https%3A%2F%2Fiam.googleapis.com%2F***");
      HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
      connection.connect();

      System.out.println("Response Code : " + connection.getResponseCode());

      System.out.println("Cipher Suite : " + connection.getCipherSuite());
      Certificate[] certs = connection.getServerCertificates();
      for (Certificate cert : certs) {
        System.out.println("Cert Type : " + cert.getType());
        System.out.println("Cert Hash Code : " + cert.hashCode());
        System.out.println("Cert Public Key Algorithm : " + cert.getPublicKey().getAlgorithm());
        System.out.println("Cert Public Key Format : " + cert.getPublicKey().getFormat());
        if (cert instanceof X509Certificate) {
          X509Certificate x509cert = (X509Certificate) cert;
          System.out.println("Cert Subject DN : " + x509cert.getSubjectDN());
          System.out.println("Cert Issuer DN : " + x509cert.getIssuerDN());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.out.println("######################### CHECK1: END ##########################");
    }
  }

  public void simbaTest() {
    System.out.println("######################### SIMBATEST: START ##########################");
    Connection connection = null;
    try {
      String connectionUrl = "jdbc:bigquery://https://googleapis.com/bigquery/v2:443;ProjectId=something;OAuthType=3;LogLevel=6;LogPath=/tmp/";
      com.simba.googlebigquery.jdbc.DataSource ds = new com.simba.googlebigquery.jdbc.DataSource();
      ds.setURL(connectionUrl);
      connection = ds.getConnection();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.out.println("######################### SIMBATEST: END ##########################");

      if (connection != null) {
        try {
          connection.close();
        } catch (Exception e2) {
          e2.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    SSLTest test = new SSLTest();
    test.check1();
    test.simbaTest();
  }
}

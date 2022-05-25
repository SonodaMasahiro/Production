package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.StudentBean;

public class StudentService {
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/Student";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    /* タイムフォーマット */
    private static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    /* ログイン時間をUPDATEするクエリ */
    private static final String SQL_UPDATE = "UPDATE  student_table SET Login_Time = ?  WHERE id = ?";

    private static final String SQL_SELECT = "SELECT * FROM student_table WHERE Id = ? AND PassWord = ?";

    StudentBean StudentData = null;

    // 送信されたIDとPassWordを元にDB内の生徒情報を検索する
    public StudentBean search(String id, String password) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            // DBに接続
            Class.forName(POSTGRES_DRIVER);
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
            statement = connection.createStatement();

            // 処理が実行された時間をフォーマットに合わせて生成
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);

            // preparedStatementで使用するから、String型に変換
            String login_time = sdf.format(cal.getTime());

            // ログイン時間をテーブルに登録する処理
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, login_time);
            preparedStatement.setString(2, id);

            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(SQL_SELECT);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String resultId = resultSet.getString("id");
                String resultName = resultSet.getString("name");
                String resultGender = resultSet.getString("gender");
                String resultAddres = resultSet.getString("addres");
                String resultContact = resultSet.getString("contact");
                String resultTel = resultSet.getString("tel");
                String resultSchool = resultSet.getString("school");
                String resultClassification = resultSet.getString("classification");
                String resultSchool_year = resultSet.getString("school_year");
                String resultGood_subject = resultSet.getString("good_subject");
                String resultWeak_subject = resultSet.getString("weak_subject");
                String resultHobby = resultSet.getString("hobby");
                String resultFeature = resultSet.getString("feature");
                String resultImportant_point = resultSet.getString("important_point");
                String resultTeach_material = resultSet.getString("teach_material");
                String resultLoginTime = resultSet.getString("login_time");

                StudentData = new StudentBean();
                StudentData.setId(resultId);
                StudentData.setName(resultName);
                StudentData.setGender(resultGender);
                StudentData.setAddres(resultAddres);
                StudentData.setContact(resultContact);
                StudentData.setTel(resultTel);
                StudentData.setSchool(resultSchool);
                StudentData.setClassification(resultClassification);
                StudentData.setSchool_year(resultSchool_year);
                StudentData.setGood_subject(resultGood_subject);
                StudentData.setWeak_subject(resultWeak_subject);
                StudentData.setHobby(resultHobby);
                StudentData.setFeature(resultFeature);
                StudentData.setImportant_point(resultImportant_point);
                StudentData.setTeach_material(resultTeach_material);
                StudentData.setLogin_Time(resultLoginTime);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return StudentData;

    }
}
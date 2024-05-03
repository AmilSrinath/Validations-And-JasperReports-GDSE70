package lk.ijse.gdse70.Repo;
import lk.ijse.gdse70.Model.Customer;
import lk.ijse.gdse70.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amil Srinath
 */
public class CustomerRepo {
    public static List<Customer> getAll() throws SQLException {
        String sql = "SELECT * FROM customer";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            customerList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            ));
        }
        return customerList;
    }

    public static boolean save(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, customer.getId());
        pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, customer.getContact());
        pstm.setObject(5, customer.getNic());
        pstm.setObject(6, customer.getEmail());
        pstm.setObject(7, customer.getSalary());
        pstm.setObject(8, customer.getAge());

        return pstm.executeUpdate() > 0;
    }

    public static boolean update(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name=?, address=?, contact=?, nic=?, email=?, salary=?, age=? WHERE id=?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, customer.getName());
        pstm.setObject(2, customer.getAddress());
        pstm.setObject(3, customer.getContact());
        pstm.setObject(4, customer.getNic());
        pstm.setObject(5, customer.getEmail());
        pstm.setObject(6, customer.getSalary());
        pstm.setObject(7, customer.getAge());
        pstm.setObject(8, customer.getId());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM customer WHERE id=?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }

    public static Customer search(String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE id=?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        } else {
            return null;
        }
    }
}

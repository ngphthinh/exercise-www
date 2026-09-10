package org.ngphthinh.dao;

import lombok.RequiredArgsConstructor;
import org.ngphthinh.model.Account;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class AccountDAO {
    private final DataSource dataSource;

    public List<Account> getAllAccounts() {
        String query = """
                SELECT id, first_name, last_name, password, email, date_of_birth, gender
                FROM Accounts
                """;
        try (PreparedStatement statement = this.dataSource.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()) {
                accounts.add(Account.builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .password(resultSet.getString("password"))
                        .email(resultSet.getString("email"))
                        .dateOfBirth(resultSet.getDate("date_of_birth"))
                        .gender(resultSet.getString("gender"))
                        .build());
            }
            return accounts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addAccount(Account account) {
        String query = """
                INSERT INTO Accounts (first_name, last_name, password, email, date_of_birth, gender)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (
                PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getLastName());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setDate(5, new java.sql.Date(account.getDateOfBirth().getTime()));
            preparedStatement.setString(6, account.getGender());
            return preparedStatement.executeUpdate() == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

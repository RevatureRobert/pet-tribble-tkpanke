package dao;

import models.Lab;
import models.Tribble;
import service.LabService;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TribbleDao implements GenericDao<Tribble> {

	public TribbleDao() {	}

	@Override
	public List<Tribble> getList() {
		Connection conn = ConnectionUtil.getConnection();
		ArrayList<Tribble> list = new ArrayList<Tribble>();
		// gotta get the lab whence came this trib
		LabService labServe = new LabService();

		try {
			PreparedStatement getTribs = conn.prepareStatement("select * from \"Tribbles\"");
			ResultSet tribs = getTribs.executeQuery();

			while (tribs.next()) {
				list.add(new Tribble(tribs.getInt("ID"), tribs.getString("Name"),
						tribs.getInt("Age"), labServe.getById(tribs.getInt("Lab"))));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return list;
	}

	@Override
	public Tribble getById(int id) {
		Connection conn = ConnectionUtil.getConnection();
		Tribble fetchedTrib = null;
		// gotta get the lab whence came this trib
		LabService labServe = new LabService();

		try {
			PreparedStatement getTrib = conn.prepareStatement("select * from \"Tribbles\" where \"ID\" = ?");
			getTrib.setInt(1, id);
			ResultSet tribData = getTrib.executeQuery();
			tribData.next();
			fetchedTrib = new Tribble(tribData.getInt("ID"), tribData.getString("Name"),
					tribData.getInt("Age"), labServe.getById(tribData.getInt("Lab")));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return fetchedTrib;
	}

	@Override
	public void insert(Tribble tribble) {
		Connection conn = ConnectionUtil.getConnection();

		try {
			PreparedStatement insertTrib = conn.prepareStatement(
					"insert into \"Tribbles\" values (?, ?, ?, ?)");
			insertTrib.setInt(1, tribble.getId());
			insertTrib.setString(2, tribble.getName());
			insertTrib.setInt(3, tribble.getAge());
			insertTrib.setInt(4, tribble.getLab().getId());
			insertTrib.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void update(Tribble tribble) {
		Connection conn = ConnectionUtil.getConnection();

		try {
			PreparedStatement updateTrib = conn.prepareStatement(
					"update \"Tribbles\" set \"Name\" = ?, \"Age\" = ?, \"Lab\" = ? where \"ID\" = ?");
			updateTrib.setString(1, tribble.getName());
			updateTrib.setInt(2, tribble.getAge());
			updateTrib.setInt(3, tribble.getLab().getId());
			updateTrib.setInt(4, tribble.getId());
			updateTrib.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void delete(Tribble tribble) {
		Connection conn = ConnectionUtil.getConnection();

		try {
			PreparedStatement deleteTrib = conn.prepareStatement(
					"delete from \"Tribbles\" where \"ID\" = ?");
			deleteTrib.setInt(1, tribble.getId());
			deleteTrib.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}

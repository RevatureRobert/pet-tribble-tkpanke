package dao;

import models.Lab;
import util.ConnectionUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabDao implements GenericDao<Lab> {

	public LabDao() {	}

	@Override
	public List<Lab> getList() {
		Connection conn = ConnectionUtil.getConnection();
		ArrayList<Lab> labList = new ArrayList<Lab>();

		try {
			PreparedStatement getLabs = conn.prepareStatement("select * from \"Labs\"");
			ResultSet labs = getLabs.executeQuery();

			while (labs.next()) {
				labList.add(new Lab(labs.getInt("ID"), labs.getString("Location"),
						labs.getInt("Capacity")));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return labList;
	}

	@Override
	public Lab getById(int id) {
		Connection conn = ConnectionUtil.getConnection();
		Lab fetchedLab = null;

		try {
			PreparedStatement getLab = conn.prepareStatement("select * from \"Labs\" where \"ID\" = ?");
			getLab.setInt(1, id);
			ResultSet labData = getLab.executeQuery();
			labData.next();
			fetchedLab = new Lab(labData.getInt("ID"), labData.getString("Location"),
					labData.getInt("Capacity"));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return fetchedLab;
	}

	@Override
	public void insert(Lab lab) {
		Connection conn = ConnectionUtil.getConnection();

		try {
			PreparedStatement insertLab = conn.prepareStatement(
					"insert into \"Labs\" values (?, ?, ?)");
			insertLab.setInt(1, lab.getId());
			insertLab.setString(2, lab.getLocation());
			insertLab.setInt(3, lab.getCapacity());
			insertLab.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void update(Lab lab) {
		Connection conn = ConnectionUtil.getConnection();

		try {
			PreparedStatement updateLab = conn.prepareStatement(
					"update \"Labs\" set \"Location\" = ?, \"Capacity\" = ? where \"ID\" = ?");
			updateLab.setString(1, lab.getLocation());
			updateLab.setInt(2, lab.getCapacity());
			updateLab.setInt(3, lab.getId());
			updateLab.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void delete(Lab lab) {
		Connection conn = ConnectionUtil.getConnection();

		try {
			PreparedStatement deleteLab = conn.prepareStatement(
					"delete from \"Labs\" where \"ID\" = ?");
			deleteLab.setInt(1, lab.getId());
			deleteLab.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}

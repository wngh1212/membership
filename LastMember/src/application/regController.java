package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class regController implements Initializable {
	@FXML TextField txtId, txtName, txtHakbun, txtMajor, txtPhone, txtAddress;
	@FXML PasswordField txtPwd1, txtPwd2;
	@FXML Button btnReg, btnClose, btnCancel;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	public void btnRegAction(ActionEvent event) {
		DBConnection connNow = new DBConnection();
		Connection conn = connNow.getConnection();
		
		String sql = "INSERT INTO SMEMBER " +
				     "(USERID,USERPWD,UNAME,UNUMBER,UPHONE,UMAJOR,UADDRESS) VALUES (" +
				     " ?,?,?,?,?,?,? )";
//		System.out.println(sql);
		try{
			// 데이터베이스에 값을 저장합니다
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, txtId.getText());
			pstmt.setString(2, txtPwd1.getText());
			pstmt.setString(3, txtName.getText());
			pstmt.setString(4, txtHakbun.getText());
			pstmt.setString(5, txtPhone.getText());
			pstmt.setString(6, txtMajor.getText());
			pstmt.setString(7, txtAddress.getText());
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			txtId.setText("");
			txtName.setText("");
			txtHakbun.setText("");
			txtMajor.setText("");
			txtPhone.setText("");
			txtAddress.setText("");
			txtPwd1.setText("");
			txtPwd2.setText("");
			
		}catch(Exception e){
			e.printStackTrace();
		}              
	}
	public void btnCloseAction(ActionEvent event) {
}
	public void btnCancelAction(ActionEvent event) {
		txtId.setText("");
		txtName.setText("");
		txtHakbun.setText("");
		txtMajor.setText("");
		txtPhone.setText("");
		txtAddress.setText("");
		txtPwd1.setText("");
		txtPwd2.setText("");
	}
		
	}

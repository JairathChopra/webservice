package db;

import model.BaseRequest;
import model.BaseResponse;
import model.ZoomLink;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:zoom.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static BaseResponse getZoomLink(BaseRequest baseRequest){
        PreparedStatement ps = null;
        BaseResponse baseResponse = new BaseResponse();
        List<ZoomLink> zoomLinkList = new ArrayList<>();
        try {

            ps = connect().prepareStatement("Select meeting_id,url,password from zoom_links where surname = ? and username = ?");

            ps.setString(1,baseRequest.getSurname());
            ps.setString(2,baseRequest.getUsername());

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ZoomLink zoomLink = new ZoomLink();
                zoomLink.setMeetingId(rs.getString(1));
                zoomLink.setUrl(rs.getString(2));
                zoomLink.setPassword(rs.getString(3));

                zoomLinkList.add(zoomLink);
            }

            baseResponse.setZoomLinkList(zoomLinkList);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return baseResponse;
    }
}

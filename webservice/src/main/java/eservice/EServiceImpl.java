package eservice;

import db.DBConnection;
import model.BaseRequest;
import model.BaseResponse;

import javax.jws.WebService;

@WebService(endpointInterface = "eservice.EService")
public class EServiceImpl implements EService {
    @Override
    public BaseResponse getZoomLink(BaseRequest baseRequest) {
        return DBConnection.getZoomLink(baseRequest);
    }
}

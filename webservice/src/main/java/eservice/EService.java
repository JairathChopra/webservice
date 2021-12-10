package eservice;

import model.BaseRequest;
import model.BaseResponse;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface EService {
    @WebMethod
    public BaseResponse getZoomLink(BaseRequest baseRequest);
}

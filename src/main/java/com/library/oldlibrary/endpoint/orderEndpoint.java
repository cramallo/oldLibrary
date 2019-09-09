package com.library.oldlibrary.endpoint;

import com.library.oldlibrary.service.OrderService;
import com.oldlibrary.books.GetBookDetailsResponse;
import com.oldlibrary.books.GetOrderRequest;
import com.oldlibrary.books.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class orderEndpoint {

    @Autowired
    OrderService orderService;

    @PayloadRoot(namespace = "http://oldLibrary.com/books",
    localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrderRequest(@RequestPayload GetOrderRequest request){
        GetOrderResponse orderResponse = new GetOrderResponse();
        //tomo lo mockeado del service, order tendria q ser un id pero
        //x ahora le paso el isbn
        orderResponse.setOrder(orderService.getOrderDetail(request.getOrder()));
        return orderResponse;
    }
}

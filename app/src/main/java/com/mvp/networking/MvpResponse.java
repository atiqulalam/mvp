package com.mvp.networking;

import java.util.ArrayList;

import okhttp3.Headers;
import okhttp3.ResponseBody;


/**
 * Created by craterzone on 21/9/16.
 */

public class MvpResponse<T> {

    private int responseCode;
    private T response;
    private Headers headers;
    private ArrayList<T> responseList;
    private ResponseBody responseError;


    public MvpResponse(int responseCode, T response) {
        super();
        this.responseCode = responseCode;
        this.response = response;
    }


    public MvpResponse(int responseCode, T response, Headers headers) {
        super();
        this.responseCode = responseCode;
        this.response = response;
        this.headers = headers;
    }

    public MvpResponse(int responseCode, T response, ResponseBody responseError, Headers headers) {
        super();
        this.responseCode = responseCode;
        this.response = response;
        this.responseError = responseError;
        this.headers = headers;
    }

    public MvpResponse(int responseCode, ArrayList<T> responseList) {
        super();
        this.responseCode = responseCode;
        this.responseList = responseList;
    }

    public MvpResponse(int responseCode, ArrayList<T> responseList, Headers headers) {
        super();
        this.responseCode = responseCode;
        this.responseList = responseList;
        this.headers = headers;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public ArrayList<T> getResponseList() {
        return responseList;
    }

    public void setResponseList(ArrayList<T> responseList) {
        this.responseList = responseList;
    }

    public ResponseBody getResponseError() {
        return responseError;
    }

    public void setResponseError(ResponseBody responseError) {
        this.responseError = responseError;
    }
}

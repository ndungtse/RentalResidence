package rw.rca.rentalresidence.util;

public class CustomResponse<DataType> {
    private String message;
    private String devMessage;
    private DataType data;
    private boolean success;

    public CustomResponse(String message, DataType data, boolean success, String devMessage) {
        this.message = message;
        this.data = data;
        this.success = success;
        this.devMessage = devMessage;
    }

    public CustomResponse(String message) {
        this.message = message;
    }

    public CustomResponse(String message, DataType data, Boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public CustomResponse(String message, String devMessage) {
        this.message = message;
        this.devMessage = devMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataType getData() {
        return data;
    }

    public void setData(DataType data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setDevMessage(String devMessage) {
        this.devMessage = devMessage;
    }

    public String getDevMessage() {
        return devMessage;
    }
}

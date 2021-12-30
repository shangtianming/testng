package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonDataResult<T> {

        protected boolean success;
        protected String message;
        protected int errorCode = 0;

        @JsonProperty("result")
        protected T data;

}

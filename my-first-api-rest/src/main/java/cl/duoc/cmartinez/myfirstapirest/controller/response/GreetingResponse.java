package cl.duoc.cmartinez.myfirstapirest.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GreetingResponse {
    private int id;
    private String message;
}

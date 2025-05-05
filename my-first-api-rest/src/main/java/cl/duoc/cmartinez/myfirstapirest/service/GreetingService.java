package cl.duoc.cmartinez.myfirstapirest.service;

import cl.duoc.cmartinez.myfirstapirest.controller.response.GreetingResponse;
import cl.duoc.cmartinez.myfirstapirest.repository.GreetingRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    private GreetingRespository respository;
    public List<GreetingResponse> getGreetings() {
        return respository.getAll();
    }

    public GreetingResponse getByPosition(int elementNumber) {
        List<GreetingResponse> list = respository.getAll();
        if (elementNumber >= 0 && elementNumber < list.size()){
            return list.get(elementNumber);
        }
        return null;
    }
}

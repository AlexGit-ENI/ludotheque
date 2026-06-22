package fr.eni.ludotheque.Exeption;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClientNotFoundException extends RuntimeException {

    @NonNull private Integer idClient;

    @Override
    public String getMessage() {

        return "Le client " + idClient + " n'a pas été trouvé";

    }
}

package moshi_przyklad; /**
 * Przykład zapisu i odczytu drzewa BST do formatu JSON
 *
 * Program wymaga biblioteki Moshi dostępnej w repozytorium Maven pod:
 * com.squareup.moshi:moshi
 * com.squareup.moshi:moshi-adapters
 *
 * Dodawanie zewnętrznych bibliotek do projektu opisane jest pod adresem:
 * https://www.jetbrains.com/help/idea/library.html#define-a-project-library
 */
import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Node r = new FullNode(
                2,
                new FullNode(1, new EmptyNode(), new EmptyNode()),
                new FullNode(3, new EmptyNode(), new EmptyNode())
        );
        System.out.println("r=" + r);

        Moshi moshi = new Moshi.Builder()
                .add(
                        PolymorphicJsonAdapterFactory.of(Node.class, "type")
                                .withSubtype(FullNode.class, "full")
                                .withSubtype(EmptyNode.class, "empty")
                )
                .build();

        JsonAdapter<Node> jsonAdapter = moshi.adapter(Node.class);
        String json = jsonAdapter.toJson(r);
        System.out.println("json="+json);

        try {
            Node r2 = jsonAdapter.fromJson(json);
            System.out.println("r2="+r2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

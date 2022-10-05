package seedu.address.testutil;

import seedu.address.model.ClientBook;
import seedu.address.model.client.Client;

/**
 * A utility class to help with building ClienBook objects.
 * Example usage: <br>
 *     {@code ClientBook ab = new ClientBookBuilder().withClient("John", "Doe").build();}
 */
public class ClientBookBuilder {

    private ClientBook clientBook;

    public ClientBookBuilder() {
        clientBook = new ClientBook();
    }

    public ClientBookBuilder(ClientBook clientBook) {
        this.clientBook = clientBook;
    }

    /**
     * Adds a new {@code Client} to the {@code ClientBook} that we are building.
     */
    public ClientBookBuilder withClient(Client client) {
        clientBook.addClient(client);
        return this;
    }

    public ClientBook build() {
        return clientBook;
    }
}
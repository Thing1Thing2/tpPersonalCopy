package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.client.Address;
import seedu.address.model.client.Email;
import seedu.address.model.client.Name;
import seedu.address.model.client.Phone;
import seedu.address.model.meeting.MeetingDate;
import seedu.address.model.meeting.MeetingTime;
import seedu.address.model.product.Product;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses {@code String date} into a {@code MeetingDate}.
     */
    public static MeetingDate parseDate(String date) throws ParseException {
        requireNonNull(date);

        try {
            LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMyyyy"));
            return new MeetingDate(parsedDate);
        } catch (DateTimeParseException e) {
            throw new ParseException(MeetingDate.MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Parses {@code String time} into a {@code MeetingTime}.
     */
    public static MeetingTime parseTime(String time) throws ParseException {
        requireNonNull(time);

        try {
            LocalTime parsedTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HHmm"));
            return new MeetingTime(parsedTime);
        } catch (DateTimeParseException e) {
            throw new ParseException(MeetingTime.MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Parses a {@code String product} into a {@code Product}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code product} is invalid.
     */
    public static Product parseProduct(String product) throws ParseException {
        requireNonNull(product);
        String trimmedProduct = product.trim();
        if (!Product.isValidProductName(trimmedProduct)) {
            throw new ParseException(Product.MESSAGE_CONSTRAINTS);
        }
        return new Product(trimmedProduct);
    }

    /**
     * Parses {@code Collection<String> products} into a {@code Set<Product>}.
     */
    public static Set<Product> parseProducts(Collection<String> products) throws ParseException {
        requireNonNull(products);
        final Set<Product> productSet = new HashSet<>();
        for (String productName : products) {
            productSet.add(parseProduct(productName));
        }
        return productSet;
    }
}

package oob.tabby.Exception;

public class MustImplementFormFragmentEventsInterfaceException extends Exception {
    public static final String message = "%s must implement FormFragmentInterface";

    public MustImplementFormFragmentEventsInterfaceException(String className) {
        super(String.format(MustImplementFormFragmentEventsInterfaceException.message, className));
    }
}

package company.apple.callback;

public class B {
    private OnEventListener mListener;

    public void registerOnEventListener(OnEventListener mListener) {
        this.mListener = mListener;
    }

    public void doStuff() {
        System.out.println("Performing callback before synchronous Task.");

        if (this.mListener != null) {
            mListener.onEvent();
        }
    }

    public static void main(String[] args) {
        B obj = new B();
        OnEventListener mListener = new A();
        obj.registerOnEventListener(mListener);
        obj.doStuff();
    }
}

class A implements OnEventListener {
    @Override
    public void onEvent() {
        System.out.println("Performing callback after synchronous Task.");
    }
}

interface OnEventListener {
    void onEvent();
}

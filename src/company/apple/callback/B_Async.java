package company.apple.callback;

public class B_Async {
    private OnEventListener_Async mListener;

    public void registerOnEventListener(OnEventListener_Async mListener) {
        this.mListener = mListener;
    }

    public void doStuff() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Performing operation in Asynchronous Task.");
                if (mListener != null) {
                    mListener.onEvent();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        B_Async obj = new B_Async();
        OnEventListener_Async mListener = new A_Async();
        obj.registerOnEventListener(mListener);
        obj.doStuff();
    }
}

class A_Async implements OnEventListener_Async {
    @Override
    public void onEvent() {
        System.out.println("Performing callback after Asynchronous Task.");
    }
}

interface OnEventListener_Async {
    void onEvent();
}

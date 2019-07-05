package databinding.samples

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import databinding.utils.bind

/**
 * Observable view state for Login screen.
 */
class LoginViewState : BaseObservable() {
    @get:Bindable var username by bind(BR.username, "")
    @get:Bindable var password by bind(BR.password, "")
}
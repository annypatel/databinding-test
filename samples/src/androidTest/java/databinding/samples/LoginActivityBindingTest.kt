package databinding.samples

import androidx.test.annotation.UiThreadTest
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withText
import databinding.test.utils.bindNow
import databinding.test.utils.inflate
import org.junit.Test

class LoginActivityBindingTest {

    @Test
    @UiThreadTest
    fun bindLoginViewState() = inflate<LoginActivityBinding>(R.layout.activity_login) {
        viewState = LoginViewState()

        bindNow(viewState) {
            username = "brucewayne"
            password = "123!@#"
        }

        assertThat(etUserName, withText("brucewayne"))
        assertThat(etPassport, withText("123!@#"))
    }
}
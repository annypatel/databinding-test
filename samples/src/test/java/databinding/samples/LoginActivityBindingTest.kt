package databinding.samples

import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import databinding.test.utils.bindNow
import databinding.test.utils.inflate
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityBindingUnitTest {

    @Test
    fun bindLoginViewState() = inflate<LoginActivityBinding>(R.layout.activity_login) {
        viewState = LoginViewState()

        bindNow(viewState) {
            username = "brucewayne"
            password = "123!@#"
        }

        assertThat(etUserName, withText("brucewayne"))
        assertThat(etPassport, withText("123!@#"))
    }

    @Test
    fun clickOnLoginButton() = inflate<LoginActivityBinding>(R.layout.activity_login) {
        viewModel = mock()

        btnLogin.performClick()

        verify(viewModel)?.login()
    }
}
import './App.css'
import ListProductComponent from './components/ListProductComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import ProductComponent from './components/ProductComponent'
import RegisterComponent from './components/RegisterComponent'
import LoginComponent from './components/LoginComponent'
import ListUserComponent from './components/ListUserComponent'
import UserComponent from './components/UserComponent'
import { isUserLoggedIn } from './services/AuthService'


function App() {

  function AuthenticatedRoute({children}){

    const isAuth = isUserLoggedIn();

    if(isAuth) {
      return children;
    }

    return <Navigate to="/" />

  }

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
              {/* http://localhost:8080 */}
              <Route path='/' element = { <LoginComponent/> }></Route>
               {/* http://localhost:8080/api/products */}
              <Route path='/products' element = { 
                <AuthenticatedRoute>
                  <ListProductComponent/>
                </AuthenticatedRoute> 
              }></Route>
              {/* http://localhost:8080/api/add-product */}
              <Route path='/add-product' element = { 
                <AuthenticatedRoute>
                  <ProductComponent /> 
                </AuthenticatedRoute>
              }></Route>
              {/* http://localhost:8080/api/products/1 */}
              <Route path='/update-product/:id' element = { 
                <AuthenticatedRoute>
                  <ProductComponent /> 
                </AuthenticatedRoute>
              }></Route>
               {/* http://localhost:8080/auth/register */}
              <Route path='/register' element = { <RegisterComponent />}></Route>

               {/* http://localhost:8080/auth/login */}
               <Route path='/login' element = { <LoginComponent /> }></Route>
               {/* {User roots} */}
               {/* http://localhost:8080/api/users */}
              <Route path='/users' element = { 
                <AuthenticatedRoute>
                  <ListUserComponent/>
                </AuthenticatedRoute> 
              }></Route>
              {/* http://localhost:8080/api/add-user */}
              <Route path='/add-user' element = { 
                <AuthenticatedRoute>
                  <UserComponent/> 
                </AuthenticatedRoute>
              }></Route>
              {/* http://localhost:8080/api/users/1 */}
              <Route path='/update-user/:id' element = { 
                <AuthenticatedRoute>
                  <UserComponent /> 
                </AuthenticatedRoute>
              }></Route>
          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App

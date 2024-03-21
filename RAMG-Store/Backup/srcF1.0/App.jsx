import './App.css'
import ListUserComponent from './Components/ListUserComponent'
import HeaderComponent from './Components/HeaderComponent'
import FooterComponent from './Components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import UserComponent from './Components/UserComponent'

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent/>
        <Routes>
          <Route path='/' element={<ListUserComponent/>}></Route>
          <Route path='/users' element={<ListUserComponent/>}></Route>
          <Route path='/add-user' element={<UserComponent/>}></Route>
          <Route path='/edit-user/:id' element={<UserComponent/>}></Route>
        </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App

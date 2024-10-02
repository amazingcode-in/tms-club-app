import './App.css';
import {  } from 'bootstrap';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import MemberProfile from './component/member/MemberProfile';
import Login from './component/navigation/Login';
import AdminPanel from './component/admin/AdminPanel';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* navigation section */}
        <Route path='/' element = {<Login/>}/>

        {/* admin section */}
        <Route path='/admin-panel' element = {<AdminPanel/>}/>

        {/* member section */}
        <Route path='/member-profile' element = {<MemberProfile/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

import {
  BrowserRouter,
  Routes,
  Route,
  useSearchParams,
} from "react-router-dom";
import NotFound from "./components/NotFound";
import SignIn from "./components/SignIn";
import Home from "./components/Home";
import Form from "./components/Form";
import Profile from "./components/Profile";

function App() {
  const queryParams = new URLSearchParams(window.location.search);
  let id = queryParams.get('id');
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={id != null ? <Home id={id}/> : <SignIn/>} />
        <Route path="/signin" element={<SignIn/>} />
        <Route path="/operation" element={<Form id={id}/>} />
        <Route path="/profile" element={<Profile id={id}/>} />
        <Route
          path="*"
          element={
            <NotFound
              message="Not Found"
              code="404"
              path="/"
              button="Go Home"
            />
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

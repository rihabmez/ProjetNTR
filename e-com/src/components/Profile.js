import React from "react";
import NotFound from "./NotFound";
import NavBar from "./NavBar";

const isLogged = true;
function Profile({id}) {
  return (
    <>
      {isLogged ? (
        <NavBar id={id}/>
      ) : (
        <NotFound message="Not allowed" code="400" path="/" button="Go Home" />
      )}
      <div className="main">
        <div className="image"></div>
        <div className="name">
          <p>Simp</p>
        </div>
        <div className="username">
          <p>@simpyy</p>
        </div>
        <div className="work">
          <p>Front-end developer </p>
        </div>
        <div>
          <button>Follow</button>
        </div>
      </div>
    </>
  );
}

export default Profile;

import { React, useEffect, useState } from "react";
import Footer from "./Footer";
import Table from "./Table";
import axios from "axios";

function Home({ id }) {
  const [user, setUser] = useState({});
  const [operations, setOperations] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:1337/client/" + id)
      .then((res) => {
        setUser(res.data);
      })
      .catch(console.log("cant fetch data"));

    axios
      .get("http://localhost:1337/client/operation/" + id)
      .then((res) => {
        setOperations(res.data);
      })
      .catch(console.log("cant fetch data"));
  }, []);
  console.log("-----------------------------");
  console.log(user);
  console.log(operations);
  console.log("-----------------------------");

  return (
    <>
      <Table
        id={id}
        header={Object.keys(operations[0])}
        data={operations}
        message={"Bienvenue " + user.firstName}
        balance={user.balance}
      />
      <Footer />
    </>
  );
}

export default Home;

import { React, useEffect, useState } from "react";
import axios from "axios";

export default function SignIn() {
  const [ids, setIds] = useState([]);
  const [id, setId] = useState("");
  const getId = (e) => {
    setId(e.target.value);
  };
  useEffect(() => {
    axios.get("http://localhost:1337/client/ids").then((res) => {
      setIds(res.data);
    });
  }, []);
  return (
    <>
      <div className="min-h-full flex items-center justify-center py-12 px-4 sm:px-6">
        <div className="max-w-md w-full space-y-8">
          <div>
            <img
              className="mx-auto h-12 w-auto"
              src="https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg"
              alt="Workflow"
            />
            <h2 className="mt-6 text-center text-3xl font-extrabold text-gray-900">
              Entrer l'ID du client
            </h2>
          </div>
          <form className="mt-8 space-y-6">
            <input type="hidden" name="remember" defaultValue="true" />
            <div className="rounded-md shadow-sm -space-y-px">
              <div>
                <label htmlFor="email-address" className="sr-only">
                  Email address
                </label>
                <select name="id" id="id" onChange={(e) => getId(e)}>
                  <option value=""></option>
                  {ids.map((value, key) => (
                    <option key={key} value={value}>
                      {value}
                    </option>
                  ))}
                </select>
              </div>
            </div>
            <div>
              {id != "" ? (
                <a href={"?id=" + id}>
                  <button
                    type="submit"
                    className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    onClick={() => ""}
                  >
                    Entrer
                  </button>
                </a>
              ) : (
                ""
              )}
            </div>
          </form>
        </div>
      </div>
    </>
  );
}

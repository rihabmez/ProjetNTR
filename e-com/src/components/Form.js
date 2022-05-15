import React from "react";
import NavBar from "./NavBar";
import NotFound from "./NotFound";

const isLogged = true;
function Form({id}) {
  return (
    <>
      {isLogged ? (
        <NavBar id={id}/>
      ) : (
        <NotFound message="Not allowed" code="400" path="/" button="Go Home" />
      )}
      <div className="max-w-2xl mx-auto bg-white p-16">
        <form>
          <div className="grid gap-6 mb-6 lg:grid-cols-2">
            <div>
              <label
                htmlFor="date_debut"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
              >
                Date Debut
              </label>
              <input
                type="text"
                id="date_debut"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="2019-03-01"
                required
              />
            </div>
            <div>
              <label
                htmlFor="date_fin"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
              >
                Date Fin
              </label>
              <input
                type="text"
                id="last_name"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="2021-07-11"
                required
              />
            </div>
            <div>
              <label
                htmlFor="valeur"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
              >
                Valeur
              </label>
              <input
                type="text"
                id="valeur"
                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="Street 1 ..."
                required
              />
            </div>
            <div>
              <label
                htmlFor="type"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
              >
                Type
              </label>
                <select>
                    <option>Crédit</option>
                    <option>Debit</option>
                </select>
            </div>
          </div>

          <button
            type="submit"
            className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          >
            Ajouter
          </button>
        </form>
      </div>
    </>
  );
}

export default Form;

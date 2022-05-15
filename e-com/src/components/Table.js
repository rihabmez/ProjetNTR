import { TrashIcon } from "@heroicons/react/solid";
import { React } from "react";
import Header from "./Header";
import NavBar from "./NavBar";
import NotFound from "./NotFound";

const isLogged = true;
function Table({ header, data, message, balance,id }) {
  console.log("###################")
  console.log(data)
  console.log("###################")
  if(!data && !header)
    return null;
  let titles = Object.keys(header[0]);
  titles.shift();
  return (
    <>
      {isLogged ? (
        <NavBar id={id}/>
      ) : (
        <NotFound message="Not allowed" code="400" path="/" button="Go Home" />
      )}
      <Header message={message} value={balance ? "$" + balance : ""} />
      <div className="my-5 mx-12 relative overflow-x-auto shadow-md sm:rounded-lg">
        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
          Ajouter une operation
        </button>
        <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
              {titles.map((value, key) => (
                <th key={key} scope="col" className="px-6 py-3">
                  {value}
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {data.map((value) => (
              <tr
                key={value.id}
                className="bg-white border-b dark:bg-gray-800 dark:border-gray-700"
              >
                <th
                  scope="row"
                  className="px-6 py-4 font-medium text-gray-900 dark:text-white whitespace-nowrap"
                >
                  {value.type}
                </th>
                <td className="px-6 py-4">{value.startDAte}</td>
                <td className="px-6 py-4">{value.endDate}</td>
                <td className="px-6 py-4">{"$" + value.value}</td>
                <td className="px-6 py-4 text-right">
                  <button>
                    <TrashIcon className="block h-6 w-6" aria-hidden="true" />
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Table;

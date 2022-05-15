export default function Header({message ,value}) {
    return (
      <div className="bg-gray-50 mx-40 my-5">
        <div className="text-center max-w-7xl mx-auto py-12 px-4 sm:px-6 lg:py-16 lg:px-8 lg:flex lg:items-center lg:justify-between">
          <h2 className=" text-3xl font-extrabold tracking-tight text-gray-900 sm:text-4xl ">
            <span className="block">{message}</span>
            <span className="block text-indigo-600">{value}</span>
          </h2>
        </div>
      </div>
    )
  }
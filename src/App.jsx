// App.jsx
// Meu componente principal do site de receitas (eu que fiz 😎)
import Navbar from "./components/Navbar";
import Hero from "./components/Hero";
import Receitas from "./components/Receitas";

function App() {
  return (
    <>
      <Navbar />
      <Hero />
      <Receitas />
    </>
  );
}

export default App;
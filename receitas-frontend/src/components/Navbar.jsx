// Navbar.jsx
// Menu principal do site (com icones bonitinhos 😍)
import { FaHome, FaUtensils, FaStar } from "react-icons/fa";

export default function Navbar() {
  return (
    <nav
      style={{
        background: "#fff",
        padding: "15px 20px",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        boxShadow: "0 2px 10px rgba(0,0,0,0.1)",
        position: "sticky",
        top: 0,
        zIndex: 10,
      }}
    >
      <h1 style={{ fontSize: "22px", fontWeight: 700 }}>🍰 Receitas da Tia Nanda</h1>

      <ul style={{ display: "flex", gap: "25px", listStyle: "none" }}>
        <li style={{ display: "flex", alignItems: "center", gap: "5px" }}>
          <FaHome /> Início
        </li>

        <li style={{ display: "flex", alignItems: "center", gap: "5px" }}>
          <FaUtensils /> Receitas
        </li>

        <li style={{ display: "flex", alignItems: "center", gap: "5px" }}>
          <FaStar /> Favoritos
        </li>
      </ul>
    </nav>
  );
}
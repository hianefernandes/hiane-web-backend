// Receitas.jsx
// Sessão que lista todas as receitas em forma de grid

import { receitas } from "../data/receitas";
import ReceitaCard from "./ReceitaCard";

export default function Receitas() {
  return (
    <section style={{ padding: "40px" }}>
      <h2 style={{ fontSize: "26px", marginBottom: "25px" }}>Receitas em destaque ✨</h2>

      <div
        style={{
          display: "grid",
          gridTemplateColumns: "repeat(auto-fit, minmax(250px, 1fr))",
          gap: "25px",
        }}
      >
        {receitas.map((r) => (
          <ReceitaCard key={r.id} {...r} />
        ))}
      </div>
    </section>
  );
}
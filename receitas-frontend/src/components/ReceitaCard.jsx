// ReceitaCard.jsx
// Meu card de receitas, com sombra leve e efeito bonito

export default function ReceitaCard({ nome, imagem, descricao }) {
  return (
    <div
      style={{
        background: "#fff",
        borderRadius: "12px",
        overflow: "hidden",
        boxShadow: "0 4px 14px rgba(0,0,0,0.1)",
        transition: "transform .2s",
      }}
    >
      <img src={imagem} alt={nome} style={{ width: "100%", height: "180px", objectFit: "cover" }} />

      <div style={{ padding: "15px" }}>
        <h3 style={{ fontSize: "20px", marginBottom: "10px" }}>{nome}</h3>
        <p style={{ color: "#555" }}>{descricao}</p>
      </div>
    </div>
  );
}
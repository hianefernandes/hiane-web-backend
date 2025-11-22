// Hero.jsx
// Banner inicial do site com imagem bonita e texto chamativo

export default function Hero() {
  return (
    <section
      style={{
        background: "url('https://images.unsplash.com/photo-1505253758473-96b7015fcd40') center/cover",
        height: "320px",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        color: "#fff",
        textShadow: "0 2px 10px rgba(0,0,0,0.8)",
      }}
    >
      <h2 style={{ fontSize: "32px", fontWeight: 800 }}>
        As melhores receitas para o seu dia ❤️
      </h2>
    </section>
  );
}
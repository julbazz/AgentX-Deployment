$projectPath = "E:\programme\eclipse\Workspace\SoftwareDeployment\AgentX-Deployment"

Get-ChildItem -Path $projectPath -Recurse -File -Include *.java,*.gradle,*.yml,*.yaml,*.properties | ForEach-Object {

    try {
        $file = $_.FullName

        $content = Get-Content $file -Raw -ErrorAction Stop

        # BOM + kaputte Startzeichen entfernen
        $content = $content -replace "^\uFEFF", ""
        $content = $content -replace "^\?", ""

        Set-Content -Path $file -Value $content -Encoding UTF8

        Write-Host "Fixed: $file"
    }
    catch {
        Write-Host "SKIP (no access or invalid file): $($_.FullName)"
    }
}

Write-Host "DONE: Encoding cleanup completed safely"